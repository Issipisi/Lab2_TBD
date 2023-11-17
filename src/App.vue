<template>
  <div>
      <router-link class='router-link' to="/creartarea">Crear Tarea</router-link>
      <router-link class='router-link' :to="'/actualizar-tarea/' + id">Actualizar Tarea</router-link>
      <router-link class='router-link' to="/login">Iniciar Sesión</router-link>
      <router-link class='router-link' to="/register">Registrarse</router-link>
      <router-link class='router-link' to="/emergencias">Emergencias</router-link>
    <router-view />
    </div>
</template>

<script>
export default {
  data() {
    return {
      id: null,  // Asegúrate de inicializarla con el valor adecuado o como null
      // Otras propiedades de data...
    };
  },
  // Otras secciones del componente...
};
</script>
<style>
.router-link{
  margin: 25px;
  font-weight: 500;
  color: black;
  text-decoration: none;
  font-size: 21px;
  border-bottom: solid 1px;
}
.router-link:hover{
  opacity: 0.3;
}
</style>
