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
          <label class="form-label">Seleccione la ubicación:</label>
          <map-component @location-selected="updateLocation"></map-component>
        </div>
        <div class="form-group">
          <button class="btn btn-report">Reportar Emergencia</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import MapComponent from './MapComponent.vue';

export default {
  components: {
    MapComponent,
  },
  data() {
    return {
      nombre: '',
      descripcion: '',
      ubicacion: null,
    };
  },
  methods: {
    updateLocation(location) {
      this.ubicacion = {
        type: 'Point',
        coordinates: [location.lng, location.lat],
      };
    },
    async reportarEmergencia() {
      const requestData = {
        nombre: this.nombre,
        descripcion: this.descripcion,
        ubicacion: this.ubicacion,
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

        } else {
          console.error('Error al reportar emergencia');
        }
      } catch (error) {
        console.error('Error al comunicarse con el servidor', error);
      }
    },
  },
};
</script>

<style scoped>
.emergency-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f8f9fa;
}

.form-container {
  max-width: 400px;
  margin: auto;
  padding: 20px;
  background-color: rgba(255, 255, 255, 0.8);
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
}

.form-group input,
.form-group textarea {
  width: 100%;
  padding: 10px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.btn-report {
  background-color: #dc3545;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.btn-report:hover {
  background-color: #c82333;
}

h1 {
  text-align: center;
  color: #333;
}
</style>
