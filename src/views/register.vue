<template>
  <div class="container">
    <h1 class="mt-4" style="text-align: center">Registro</h1>
    <div class="row">
      <div class="col">
        <form @submit.prevent="enviarRegistro">
          <div class="row">
            <div class="col-md-5">
              <!-- Campos de entrada -->

              <!-- Nombres -->
              <div class="mb-2">
                <label for="nombres" class="form-label">Nombres:</label>
                <input v-model="nombres" id="nombres" class="form-control" placeholder="Juan" type="text" />
              </div>
              <!-- Apellidos -->
              <div class="mb-2">
                <label for="apellidos" class="form-label">Apellidos:</label>
                <input v-model="apellidos" id="apellidos" class="form-control" placeholder="Perez" type="text" />
              </div>
              <!-- Correo -->
              <div class="mb-2">
                <label for="correo" class="form-label">Correo:</label>
                <input v-model="correo" id="correo" class="form-control" placeholder="ejemplo@dominio.com" type="email" />
              </div>
              <!-- Contraseña -->
              <div class="mb-2">
                <label for="contrasena" class="form-label">Contraseña:</label>
                <input v-model="contrasena" id="contrasena" class="form-control" placeholder="password" type="password" />
              </div>
              <!-- Repetir Contraseña -->
              <div class="mb-2">
                <label for="password2" class="form-label">Repita su contraseña:</label>
                <input v-model="contrasena2" id="password2" class="form-control" placeholder="password" type="password" />
              </div>
              <div class="mb-2">
                <label class="form-label">Seleccione su ubicación:</label>
                <map-component @location-selected="updateLocation"></map-component>
              </div>
            </div>
            <div class="col-md-2"></div>
            <div class="row mt-4">
              <div class="col text-center">
                <button id="enviarRegister" class="btn btn-primary">Registrarse</button>
              </div>
            </div>
          </div>
        </form>
      </div>
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
          body: JSON.stringify(requestData)
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
    }
  }
}
</script>


<style scoped>

</style>