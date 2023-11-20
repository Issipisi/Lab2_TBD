<template>
  <div class="page-container">
    <div class="form-container">
      <h1>Crear Tarea</h1>
      <form @submit.prevent="crearTarea">
        <div class="form-group">
          <label for="nombretarea">Nombre Tarea:</label>
          <input v-model="nombreselecionado" id="nombretarea" type="text" required />
        </div>
        <div class="form-group">
          <label for="descripcion">Descripción:</label>
          <textarea v-model="descripcion" id="descripcion" required></textarea>
        </div>
        <div class="form-group">
          <label for="emergencia">Emergencia:</label>
          <select v-model="emergenciaSeleccionada" id="emergencia" required>
            <option v-for="emergencia in emergencias" :key="emergencia.id" :value="emergencia.id">
              {{ emergencia.nombre }}
            </option>
          </select>
        </div>
        <div class="form-group">
          <label for="estadoTareaId">Estado de Tarea:</label>
          <select v-model="estadoTareaId" id="estadoTareaId" required>
            <option value="1">Pendiente</option>
            <option value="2">En proceso</option>
          </select>
        </div>
        <button type="submit" class="btn">Crear Tarea</button>
        <div v-if="tareaCreadaMensaje" class="mensaje-exito">Tarea creada correctamente.</div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  // ... (sin cambios en la sección data y methods)
}
</script>

<style scoped>
.page-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: url('@/assets/imagen6.jpg') center/cover no-repeat;
}

.form-container {
  max-width: 600px;
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
.form-group textarea,
.form-group select {
  width: 100%;
  padding: 10px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.btn {
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

.btn:hover {
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

h1 {
  text-align: center;
  color: #333;
}
</style>
