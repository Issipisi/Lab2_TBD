<template>
  <div class="register-container">
    <h1 class="mt-4">Registro</h1>
    <div class="form-container">
      <form @submit.prevent="enviarRegistro">
        <!-- Campos de entrada -->
        <div class="form-group">
          <label for="nombres" class="form-label">Nombres:</label>
          <input v-model="nombres" id="nombres" class="form-control" placeholder="Juan" type="text" />
        </div>
        <div class="form-group">
          <label for="apellidos" class="form-label">Apellidos:</label>
          <input v-model="apellidos" id="apellidos" class="form-control" placeholder="Perez" type="text" />
        </div>
        <div class="form-group">
          <label for="correo" class="form-label">Correo:</label>
          <input v-model="correo" id="correo" class="form-control" placeholder="ejemplo@dominio.com" type="email" />
        </div>
        <div class="form-group">
          <label for="contrasena" class="form-label">Contraseña:</label>
          <input v-model="contrasena" id="contrasena" class="form-control" placeholder="password" type="password" />
        </div>
        <div class="form-group">
          <label for="password2" class="form-label">Repita su contraseña:</label>
          <input v-model="contrasena2" id="password2" class="form-control" placeholder="password" type="password" />
        </div>

        <!-- Componente de Mapa para Ubicación -->
        <div class="form-group">
          <label class="form-label">Seleccione su ubicación:</label>
          <map-component @location-selected="updateLocation"></map-component>
        </div>

        <!-- Botón de envío -->
        <div class="form-group">
          <button class="btn btn-register">Registrarse</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import MapComponent from './MapComponent.vue';

export default {
  components: {
    MapComponent,
  },
  data() {
    return {
      nombres: '',
      apellidos: '',
      correo: '',
      contrasena: '',
      contrasena2: '',
      ubicacion: null,
    };
  },
  methods: {
    updateLocation(location) {
      this.ubicacion = {
        type: 'Point',
        coordinates: [location.lng, location.lat],
      };
    },
    async enviarRegistro() {
      if (this.contrasena !== this.contrasena2) {
        alert("Las contraseñas no coinciden");
        return;
      }
      const requestData = {
        nombre: this.nombres,
        apellido: this.apellidos,
        correo: this.correo,
        contrasena: this.contrasena,
        ubicacion: this.ubicacion,
      };
      try {
        console.log("Enviando Registro", requestData);
        const response = await fetch('http://localhost:8080/voluntarios/signup', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(requestData),
        });
        if (response.ok) {
          console.log('Registro enviado con éxito');
          this.$router.push('/login');
        } else {
          console.error('Error al registrar');
        }
      } catch (error) {
        console.error('Error registrando el usuario', error);
      }
    },
  },
};
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: url('../assets/imagen4.jpg') center/cover no-repeat;
}

.form-container {
  max-width: 400px;
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

.form-group input {
  width: 100%;
  padding: 10px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.btn-register {
  background-color: #3498db;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.btn-register:hover {
  background-color: #2980b9;
}

h1 {
  text-align: center;
  color: #333;
}
</style>

