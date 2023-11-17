<template>
  <div style="min-height: 100vh; display: flex; justify-content: center; align-items: center;">
    <div style="background-color: #fff; padding: 1rem; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); width: 20rem; text-align: center;">
      <h2 style="font-size: 1.5rem; font-weight: bold; margin-bottom: 1rem;">Emergencias</h2>
      <ul style="list-style: none; padding: 0;">
        <li v-for="emergencia in emergencias" :key="emergencia.id" style="margin-bottom: 0.5rem;">
          <router-link :to="'/emergencias/' + emergencia.id" style="color: #007BFF; text-decoration: none;">
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
            emergencias: []
        };
    },
    created() {
        axios.get('http://localhost:8080/emergencias')
            .then(response => {
                this.emergencias = response.data;
            })
            .catch(error => {
                console.error('Error al obtener las emergencias:', error);
            });
    }
};
</script>
