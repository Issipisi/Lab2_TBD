<template>
  <div class="page-container">
    <div class="form-container">
      <h2>Emergencias</h2>
      <ul class="emergencias-list">
        <li v-for="emergencia in emergencias" :key="emergencia.id">
          <router-link :to="'/emergencias/' + emergencia.id" class="emergencia-link">
            {{ emergencia.nombre }}
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
      emergencias: [],
    };
  },
  created() {
    // Realiza una solicitud a la API para obtener todas las emergencias
    axios
        .get("http://localhost:8080/emergencias")
        .then((response) => {
          this.emergencias = response.data;
        })
        .catch((error) => {
          console.error("Error al obtener las emergencias:", error);
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
  background: url('@/assets/imagen7.jpg') center/cover no-repeat;
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

.emergencias-list {
  list-style: none;
  padding: 0;
}

.emergencias-list li {
  margin-bottom: 0.5rem;
}

.emergencia-link {
  color: #007BFF;
  text-decoration: none;
}
</style>
