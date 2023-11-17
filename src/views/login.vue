<template>
  <div>
    <h2>Iniciar Sesión</h2>
    <form @submit.prevent="login">
      <div>
        <label for="correo">Correo:</label>
        <input type="email" v-model="correo" required />
      </div>
      <div>
        <label for="contrasena">Contraseña:</label>
        <input type="password" v-model="contrasena" required />
      </div>
      <button type="submit">Entrar</button>
    </form>
    <p v-if="error">{{ error }}</p>
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

