<template>
  <div class="cover-container">
    <h1 class="cover-title">Bienvenidos al Sistema de Voluntariado</h1>
  </div>
</template>

<script>
export default {
  name: 'CoverPage',
  // Aquí puedes añadir lógica de componentes si es necesario
};
</script>

<style scoped>
.cover-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: url('@/assets/imagen4.jpg') center/cover no-repeat;
}

.cover-title {
  color: white;
  font-size: 2em;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}
</style>

