<template>
  <div class="page-container">
    <div class="form-container">
      <h2>Voluntarios</h2>
      <ul class="voluntarios-list">
        <li v-for="voluntario in voluntariosFiltrados" :key="voluntario.id">
          {{ voluntario.nombre }}
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
      voluntarios: [],
    };
  },
  computed: {
    voluntariosFiltrados() {
      // Aquí debes implementar la lógica para filtrar los voluntarios según tus necesidades
      // En este ejemplo, simplemente se devuelve la lista completa de voluntarios.
      return this.voluntarios;
    },
  },
  created() {
    // Realiza una solicitud a la API para obtener todos los voluntarios
    axios
        .get("http://localhost:8080/voluntarios")
        .then((response) => {
          this.voluntarios = response.data;
        })
        .catch((error) => {
          console.error("Error al obtener los voluntarios:", error);
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

.voluntarios-list {
  list-style: none;
  padding: 0;
}

.voluntarios-list li {
  margin-bottom: 0.5rem;
}
</style>
