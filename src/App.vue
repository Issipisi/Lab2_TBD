<template>
  <div class="app-container">
    <nav class="navigation">
      <router-link to="/" class="back-to-home">Volver al Inicio</router-link>
      <router-link class="nav-btn" to="/creartarea">Crear Tarea</router-link>
      <router-link class="nav-btn" :to="'/actualizar-tarea/' + id">Actualizar Tarea</router-link>
      <router-link class="nav-btn" to="/login">Iniciar Sesión</router-link>
      <router-link class="nav-btn" to="/register">Registrarse</router-link>
      <router-link class="nav-btn" to="/crear-emergencia">Crear Emergencia</router-link>
      <router-link class="nav-btn" to="/emergencias">Emergencias</router-link>

    </nav>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
      id: 1,  // Asegúrate de inicializarla con el valor adecuado o como null
      // Otras propiedades de data...
    };
  },
  // Otras secciones del componente...
};
</script>

<style>
.app-container {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.back-to-home {
  display: block;
  margin-top: 20px;
  text-align: center;
  text-decoration: none;
  color: #007bff;
}

.back-to-home:hover {
  text-decoration: underline;
}
.navigation {
  background-color: #333;
  overflow-x: auto; /* Permite el desplazamiento horizontal */
  white-space: nowrap; /* Evita que los botones se apilen verticalmente */
  text-align: center;
}


.nav-btn {
  display: inline-block; /* Alinea los botones en una fila */
  margin: 10px;
  padding: 10px 15px;
  font-weight: 500;
  color: white;
  text-decoration: none;
  font-size: 18px;
  background-color: #555;
  border: none;
  border-radius: 4px;
  transition: background-color 0.3s, transform 0.2s, box-shadow 0.2s;
  cursor: pointer;
}

.nav-btn:hover, .nav-btn:focus {
  background-color: #666;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0,0,0,0.2);
}

/* Estilos para el enlace activo */
.router-link-active {
  border-bottom: 3px solid #42b983;
}

/* Estilos adicionales para mejorar la responsividad */
@media (max-width: 768px) {
  .nav-btn {
    padding: 8px 10px;
    font-size: 16px;
  }
}
</style>
