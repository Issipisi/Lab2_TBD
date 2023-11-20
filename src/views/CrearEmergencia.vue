<template>
  <div class="emergency-container">
    <h1 class="mt-4">Reportar Emergencia</h1>
    <div class="form-container">
      <form @submit.prevent="reportarEmergencia">
        <div class="form-group">
          <label for="nombre" class="form-label">Nombre de la Emergencia:</label>
          <input v-model="nombre" id="nombre" class="form-control" placeholder="Incendio, Accidente, etc." type="text" />
        </div>
        <div class="form-group">
          <label for="descripcion" class="form-label">Descripción:</label>
          <textarea v-model="descripcion" id="descripcion" class="form-control" placeholder="Describa la emergencia"></textarea>
        </div>
        <div class="form-group">
          <label for="direccion" class="form-label">Dirección:</label>
          <input v-model="direccion" id="direccion" class="form-control" placeholder="Ingrese la dirección completa" type="text" />
        </div>
        <div class="form-group">
          <label for="institucion">Institución:</label>
          <select v-model="institucionSeleccionada" id="institucion" required>
            <option v-for="institucion in instituciones" :key="institucion.id" :value="institucion.id">
              {{ institucion.nombre }}
            </option>
          </select>
        </div>
        <div class="form-group">
          <button class="btn btn-report">Reportar Emergencia</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      nombre: '',
      descripcion: '',
      direccion: '',
      institucionSeleccionada: null,
      instituciones: [],
    };
  },
  async created() {
    try {
      const response = await fetch("http://localhost:8080/instituciones", { mode: 'cors' });
      if (response.ok) {
        this.instituciones = await response.json();
      } else {
        console.error("Error al obtener las instituciones:", response.statusText);
      }
    } catch (error) {
      console.error("Error al obtener las instituciones:", error);
    }
  },
  methods: {
    async geocodificarDireccion() {
      const url = `https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(this.direccion)}`;

      try {
        const response = await fetch(url);
        if (!response.ok) throw new Error('Respuesta de red no fue ok.');

        const data = await response.json();
        if (data.length === 0) throw new Error('No se encontraron resultados.');

        const { lat, lon } = data[0];
        return `POINT(${lon} ${lat})`;
      } catch (error) {
        console.error('Error al geocodificar la dirección:', error);
        return null;
      }
    },

    async reportarEmergencia() {
      const ubicacion = await this.geocodificarDireccion();
      if (!ubicacion) {
        alert('No se pudo geocodificar la dirección ingresada.');
        return;
      }

      const requestData = {
        nombre: this.nombre,
        descripcion: this.descripcion,
        ubicacion,
        institucionId: this.institucionSeleccionada,
      };

      try {
        const response = await fetch('http://localhost:8080/emergencias', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(requestData),
        });

        if (response.ok) {
          console.log('Emergencia reportada con éxito');
          // Lógica para después de enviar el formulario
        } else {
          console.error('Error al reportar emergencia:', response.statusText);
        }
      } catch (error) {
        console.error('Error al comunicarse con el servidor:', error);
      }
    },
  },
};
</script>
<style scoped>
.emergency-container {
  display: flex;
  flex-direction: column; /* Cambiado para alinear verticalmente */
  justify-content: center;
  align-items: center; /* Asegura que todo esté centrado horizontalmente */
  min-height: 100vh;
  padding: 2rem; /* Añade un poco de padding */
  background-color: #f8f9fa;
}

.form-container {
  width: 100%;
  max-width: 600px;
  margin: auto;
  padding: 2rem;
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 1rem;
}

.form-group label {
  margin-bottom: 0.5rem;
  color: #333;
  font-weight: bold;
}

.form-group input,
.form-group textarea {
  width: calc(100% - 20px);
  padding: 10px;
  margin-bottom: 1rem;
  display: block; /* Hace que los inputs utilicen todo el ancho */
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.btn-report {
  width: 100%; /* Hace que el botón ocupe todo el ancho del contenedor */
  background-color: #dc3545;
  color: white;
  padding: 14px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.btn-report:hover {
  background-color: #c82333;
}

h1 {
  margin-bottom: 2rem;
  color: #333;
}


@media (max-width: 768px) {
  .emergency-container {
    padding: 1rem;
  }

  .form-container {
    padding: 1rem;
  }
}
</style>
