<template>
  <div style="min-height: 100vh; display: flex; justify-content: center; align-items: center;">
    <div style="background-color: #fff; padding: 1rem; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); width: 20rem;">
      <h2 style="font-size: 1.5rem; font-weight: bold; margin-bottom: 1rem;">Tareas</h2>
      <ul style="list-style: none; padding: 0;">
        <li v-for="tarea in tareasFiltradas" :key="tarea.id" style="margin-bottom: 0.5rem;">
          <router-link :to="'/tareas/' + tarea.id" style="color: #007BFF; text-decoration: none;">
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
      return this.tareas.filter(tarea => parseInt(tarea.emergenciaId) === parseInt(this.emergenciaid));
    }
  },
  created() {
    this.emergenciaid = this.$route.params.emergenciaId;
    // Realiza una solicitud a la API para obtener todas las tareas
    axios.get('http://localhost:8080/tareas')
        .then(response => {
          this.tareas = response.data;
        })
        .catch(error => {
          console.error('Error al obtener las tareas:', error);
        });
  }
};
</script>
