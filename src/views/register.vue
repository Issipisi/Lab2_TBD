<template>
  <div class="register-container">
    <div class="form-container">
      <h1>Registro de Voluntarios</h1>
      <form @submit.prevent="enviarRegistro">
        <div class="form-group">
          <label for="nombres">Nombres</label>
          <input type="text" id="nombres" v-model="nombres" required>
        </div>
        <div class="form-group">
          <label for="apellidos">Apellidos</label>
          <input type="text" id="apellidos" v-model="apellidos" required>
        </div>
        <div class="form-group">
          <label for="correo">Correo Electrónico</label>
          <input type="email" id="correo" v-model="correo" required>
        </div>
        <div class="form-group">
          <label for="contrasena">Contraseña</label>
          <input type="password" id="contrasena" v-model="contrasena" required>
        </div>
        <div class="form-group">
          <label for="contrasena2">Repetir Contraseña</label>
          <input type="password" id="contrasena2" v-model="contrasena2" required>
        </div>

        <!-- Nueva entrada para la dirección -->
        <div class="form-group">
          <label for="direccion">Dirección:</label>
          <input v-model="direccion" id="direccion" class="form-control" placeholder="Ingrese la dirección completa" type="text" required>
        </div>

        <button type="submit" class="btn btn-register">Registrarse</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      nombres: '',
      apellidos: '',
      correo: '',
      contrasena: '',
      contrasena2: '',
      direccion: '',
    };
  },
  methods: {

    async geocodificarDireccion() {
      const url = `https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(this.direccion)}`;

      try {
        const response = await fetch(url);
        if (!response.ok) throw new Error('Respuesta de red no fue ok.');

        const data = await response.json();
        if (data.length === 0) throw new Error('No se encontraron resultados.');


        const { lat, lon } = data[0];
        return `POINT(${lon} ${lat})`;
      } catch (error) {
        console.error('Error al geocodificar la dirección:', error);
        return null;
      }
    },
    async enviarRegistro() {
      const ubicacion = await this.geocodificarDireccion();
      if (!ubicacion) {
        alert('No se pudo geocodificar la dirección ingresada.');
        return;
      }

      const requestData = {
        nombre: this.nombres,
        apellido: this.apellidos,
        correo: this.correo,
        contrasena: this.contrasena,
        ubicacion, // Agrega la ubicación al objeto de solicitud
      };

      try {
        const response = await fetch('http://localhost:8080/voluntarios/signup', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(requestData),
        });

        if (response.ok) {
          console.log('Registro Enviado con éxito');
          // Lógica para después de enviar el formulario
          this.$router.push('/login');
        } else {
          console.error('Error al registrar:', response.statusText);
        }
      } catch (error) {
        console.error('Error al comunicarse con el servidor:', error);
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
