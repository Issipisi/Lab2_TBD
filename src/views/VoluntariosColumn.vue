<template>
  <div style="min-height: 100vh; display: flex; justify-content: center; align-items: center;">
    <div style="background-color: #fff; padding: 1rem; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); width: 20rem;">
      <h2 style="font-size: 1.5rem; font-weight: bold; margin-bottom: 1rem;">Voluntarios</h2>
      <ul style="list-style: none; padding: 0;">
        <li v-for="voluntario in voluntariosFiltrados" :key="voluntario.id" style="margin-bottom: 0.5rem;">
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
            voluntarios: []
        };
    },
    computed: {
      voluntariosFiltrados() {
          return this.voluntarios.filter(voluntario => parseInt(voluntario.idtarea) === parseInt(this.tareaid));
    }},
    created() {
        this.tareaid = this.$route.params.tareaId;

        axios.get('http://localhost:8080/voluntarios')
            .then(response => {
                this.voluntarios = response.data;
            })
            .catch(error => {
                console.error('Error al obtener los voluntarios:', error);
            });
    }
};
</script>
