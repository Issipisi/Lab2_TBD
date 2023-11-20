<template>
  <div class="login-container">
    <div class="login-form">
      <h1>Iniciar Sesión</h1>
      <div class="form-group">
        <label for="correo" class="form-label">Correo:</label>
        <input type="email" v-model="correo" required placeholder="Correo@example.com" class="form-input" id="correo" />
      </div>
      <div class="form-group">
        <label for="contrasena" class="form-label">Contraseña:</label>
        <input type="password" v-model="contrasena" required placeholder="Contraseña" class="form-input" id="contrasena" />
      </div>
      <button @click="login" class="login-button">Entrar</button>
      <p v-if="error" class="error-message">{{ error }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      correo: "",
      contrasena: "",
      error: null
    };
  },
  methods: {
    async login() {
      try {
        // Haciendo la solicitud de autenticación usando fetch
        const response = await fetch('http://localhost:8080/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ correo: this.correo, contrasena: this.contrasena }),
          credentials: "include"
        });

        if (!response.ok) {
          throw new Error('Autenticación fallida');
        }

        // Si la autenticación es exitosa, puedes redirigir al usuario a la página principal o donde prefieras.
        this.$router.push('/creartarea');

      } catch (error) {
        // Si hay un error (por ejemplo, credenciales incorrectas), puedes mostrar un mensaje de error.
        this.error = "Correo o contraseña incorrectos.";
      }
    }
  }
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: url('@/assets/imagen4.jpg') center/cover no-repeat;
}

.login-form {
  padding: 2em;
  background: rgba(255, 255, 255, 0.8);
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  width: 100%;
  max-width: 400px;
  box-sizing: border-box;
  text-align: center;
}

.form-group {
  margin-bottom: 1em;
}

.form-label {
  display: block;
  text-align: left;
  margin-bottom: 0.5em;
  font-size: 16px; /* Tamaño de letra ajustado para coincidir con la vista de registro */
}

.form-input {
  width: 100%;
  padding: 0.75em;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-sizing: border-box;
  margin-bottom: 1em;
  transition: border-color 0.3s;
  font-size: 16px; /* Tamaño de letra ajustado para coincidir con la vista de registro */
}

.form-input:focus {
  border-color: #b59f7b;
  outline: none;
}

.login-button {
  width: 100%;
  padding: 0.75em;
  border: none;
  border-radius: 4px;
  background-color: #b59f7b;
  color: white;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s;
  font-size: 16px; /* Tamaño de letra ajustado para coincidir con la vista de registro */
}

.login-button:hover {
  background-color: #9c8468;
}

h1 {
  text-align: center;
  color: #333;
  font-size: 24px; /* Tamaño de letra ajustado para coincidir con la vista de registro */
}

.error-message {
  color: red;
  margin-top: 1em;
  font-size: 14px; /* Tamaño de letra ajustado para coincidir con la vista de registro */
}
</style>
