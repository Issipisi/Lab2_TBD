<template>
  <div>
    <h2>Crear Tarea</h2>
    <form @submit.prevent="crearTarea">
      <!-- Input para el nombre de la tarea -->
      <label for="nombretarea">Nombre Tarea:</label>
      <input v-model="nombreselecionado" id="nombretarea" type="text" required />

      <label for="descripcion">Descripción:</label>
      <textarea v-model="descripcion" id="descripcion" required></textarea>

      <label for="emergencia">Emergencia:</label>
      <select v-model="emergenciaSeleccionada" id="emergencia" required>
        <option v-for="emergencia in emergencias" :key="emergencia.id" :value="emergencia.id">
          {{ emergencia.nombre }}
        </option>
      </select>

      <label for="estadoTareaId">Estado de Tarea:</label>
      <select v-model="estadoTareaId" id="estadoTareaId" required>
        <option value="1">Pendiente</option>
        <option value="2">En proceso</option>
      </select>

      <button type="submit">Crear Tarea</button>
      <div v-if="tareaCreadaMensaje" class="mensaje-exito">Tarea creada correctamente.</div>
    </form>

  </div>
</template>

<script>
export default {
  data() {
    return {
      nombreselecionado: '', // Será el nombre de la tarea ingresado por el usuario
      descripcion: '',
      emergenciaSeleccionada: null,
      emergencias: [],
      tareaCreada: null,
      tareaCreadaMensaje: false,
      estadoTareaId: '1', // Inicializar con "Pendiente"
    };
  },
  async created() {
    try {
      const response = await fetch("http://localhost:8080/emergencias", { mode: 'cors' });
      if (response.ok) {
        this.emergencias = await response.json();
      } else {
        console.error("Error al obtener las emergencias:", response.statusText);
      }
    } catch (error) {
      console.error("Error al obtener las emergencias:", error);
    }
  },
  methods: {
    async crearTarea() {
      try {
        const tarea = {
          nombre: this.nombreselecionado,
          descripcion: this.descripcion,
          emergenciaId: this.emergenciaSeleccionada,
          estadoTareaId: this.estadoTareaId, // Usar el valor seleccionado
        };

        const response = await fetch("http://localhost:8080/tareas", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(tarea),
        });

        if (response.ok) {
          const text = await response.text();
          this.tareaCreadaMensaje = true;
          this.nombreselecionado = '';
          this.descripcion = '';
          this.emergenciaSeleccionada = null;
          this.estadoTareaId = '1';
          setTimeout(() => {
            this.tareaCreadaMensaje = false;
          }, 7000);

          if (text) {
            try {
              this.tareaCreada = JSON.parse(text);

            } catch (parseError) {
              console.error("Error al parsear la respuesta:", parseError);
            }
          } else {
            this.tareaCreada = tarea;
          }

        } else {
          console.error("Error al crear tarea:", response.statusText);
        }
      } catch (error) {
        console.error("Error al crear tarea:", error);
      }
    }
  }
}
</script>