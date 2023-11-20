<template>
  <div class="page-container">
    <div class="form-container">
      <h2>Tareas</h2>
      <ul class="tareas-list">
        <li v-for="tarea in tareasFiltradas" :key="tarea.id">
          <router-link :to="'/tareas/' + tarea.id" class="tarea-link">
            {{ tarea.nombre }}
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      tareas: [],
    };
  },
  computed: {
    tareasFiltradas() {
      // Aquí debes implementar la lógica para filtrar las tareas según tus necesidades
      // En este ejemplo, simplemente se devuelve la lista completa de tareas.
      return this.tareas;
    },
  },
  created() {
    // Realiza una solicitud a la API para obtener todas las tareas
    axios
        .get("http://localhost:8080/tareas")
        .then((response) => {
          this.tareas = response.data;
        })
        .catch((error) => {
          console.error("Error al obtener las tareas:", error);
        });
  },
};
</script>

<style scoped>
.page-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: url('@/assets/imagen5.jpg') center/cover no-repeat;
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
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
}

.tareas-list {
  list-style: none;
  padding: 0;
}

.tareas-list li {
  margin-bottom: 0.5rem;
}

.tarea-link {
  color: #007BFF;
  text-decoration: none;
}
</style>
