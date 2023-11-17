<template>
  <div>
    <h2>Editar Tarea</h2>
    <div>
      <label for="tareaId">ID de Tarea:</label>
      <input v-model="tareaId" id="tareaId" type="text">
      <button @click="verTarea">Ver Tarea</button>
      <div v-if="tarea">
        <form @submit.prevent="actualizarTarea">
          <label for="nombretarea">Nombre Tarea:</label>
          <input v-model="tarea.nombre" id="nombretarea" type="text" required />

          <label for="descripcion">Descripción:</label>
          <textarea v-model="tarea.descripcion" id="descripcion" required></textarea>

          <label for="emergencia">Emergencia:</label>
          <select v-model="tarea.emergenciaId" id="emergencia" required>
            <option v-for="emergencia in emergencias" :key="emergencia.id" :value="emergencia.id">
              {{ emergencia.nombre }}
            </option>
          </select>

          <label for="estadoTareaId">Nuevo Estado de Tarea:</label>
          <select v-model="tarea.estadoTareaId" id="estadoTareaId" required>
            <option value="1">Pendiente</option>
            <option value="2">En Progreso</option>
            <option value="3">Completada</option>
          </select>
          <button type="submit">Actualizar Tarea</button>
        </form>
      </div>
    </div>
    <div v-if="tareaActualizada" class="mensaje-exito">Tarea Actualizada</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tarea: null, // Aquí almacenamos la tarea
      emergencias: [],
      tareaId: '',
      tareaActualizada: false,
    };
  },
  methods: {
    async verTarea() {
      try {
        const id = parseInt(this.tareaId);
        const tareaResponse = await fetch(`http://localhost:8080/tareas/${id}`);
        const emergenciasResponse = await fetch("http://localhost:8080/emergencias");

        if (tareaResponse.ok && emergenciasResponse.ok) {
          this.tarea = await tareaResponse.json();
          this.emergencias = await emergenciasResponse.json();

        } else {
          console.error("Error al obtener la tarea o las emergencias:", tareaResponse.statusText, emergenciasResponse.statusText);
        }
      } catch (error) {
        console.error("Error al obtener la tarea o las emergencias:", error);
      }
    }
    ,
    async actualizarTarea() {
      try {
        const response = await fetch(`http://localhost:8080/tareas/${this.tarea.id}`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(this.tarea),
        });

        if (response.ok) {
          this.tareaActualizada = true;
          setTimeout(() => {
            this.tareaActualizada = false;
          }, 7000);
          console.log("Tarea actualizada correctamente");
        } else {
          console.error("Error al actualizar tarea:", response.statusText);
        }
      } catch (error) {
        console.error("Error al actualizar tarea:", error);
      }
      this.tarea = null;
    },
  },
};
</script>