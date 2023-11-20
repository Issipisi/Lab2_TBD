<template>
  <div class="page-container">
    <div class="form-container">
      <h2>Editar Tarea</h2>
      <div>
        <label for="tareaId">ID de Tarea:</label>
        <input v-model="tareaId" id="tareaId" type="text">
        <button @click="verTarea">Ver Tarea</button>
        <div v-if="tarea">
          <form @submit.prevent="actualizarTarea" class="form-container">
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
  </div>
</template>

<script>
export default {
  data() {
    return {
      tarea: null,
      emergencias: [],
      tareaId: '',
      tareaActualizada: false,
    };
  },
  methods: {
    // ... (sin cambios en los métodos)
  },
};
</script>

<style scoped>
.page-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: url('@/assets/imagen6.jpg') center/cover no-repeat;
}

.form-container {
  max-width: 400px;
  padding: 20px;
  background-color: rgba(255, 255, 255, 0.8);
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h2 {
  text-align: center;
  color: #333;
}

label {
  display: block;
  margin-top: 10px;
}

input,
textarea,
select {
  width: 100%;
  padding: 10px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

button {
  width: 100%;
  background-color: #3498db;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #2980b9;
}

.mensaje-exito {
  color: #4CAF50;
  padding: 10px;
  background-color: #dff0d8;
  border: 1px solid #d6e9c6;
  border-radius: 4px;
  margin-top: 10px;
}
</style>
