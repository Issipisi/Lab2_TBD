<template>
  <div class="container">
    <h1 class="title">Detalle de Tarea</h1>
    <label for="emergencia" class="label">Selecciona una emergencia:</label>
    <select v-model="selectedEmergencia" @change="cargarVoluntarios" class="select">
      <option v-for="emergencia in emergencias" :key="emergencia.id" :value="emergencia.id">
        {{ emergencia.nombre }}
      </option>
    </select>

    <button @click="obtenerVoluntarios" class="button">Obtener Voluntarios</button>

    <div ref="map" class="map"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      lat: 40.7127837,
      lon: -74.0059413,
      apiKey: '$API_KEY',
      emergencias: [],
      selectedEmergencia: null,
      voluntarios: [] // Almacena la información de los voluntarios obtenidos del back-end
    };
  },
  mounted() {
    this.cargarEmergencias();
  },
  methods: {
    cargarEmergencias() {
      // Simulación de carga de emergencias (ajusta esto según tu implementación real)
      this.emergencias = [
        { id: 1, nombre: 'Emergencia 1' },
        { id: 2, nombre: 'Emergencia 2' },
        // ... Agrega más emergencias según sea necesario
      ];
    },
    cargarVoluntarios() {
      // Simulación de carga de voluntarios (ajusta esto según tu implementación real)
      console.log(`Cargando voluntarios para la emergencia ${this.selectedEmergencia}`);
    },
    obtenerVoluntarios() {
      if (this.selectedEmergencia) {
        // Simulación de solicitud para obtener voluntarios asociados a la emergencia seleccionada
        console.log(`Obteniendo voluntarios para la emergencia ${this.selectedEmergencia}`);

        // Simulación de datos de voluntarios (ajusta esto según tu implementación real)
        this.voluntarios = [
          { nombre: 'Voluntario 1', latitud: 40.713, longitud: -74.006 },
          { nombre: 'Voluntario 2', latitud: 40.714, longitud: -74.007 },
          // ... Agrega más voluntarios según sea necesario
        ];

        // Llama al método para actualizar el mapa con la ubicación de los voluntarios
        this.actualizarMapaConVoluntarios();
      } else {
        console.log('Selecciona una emergencia antes de obtener voluntarios.');
      }
    },
    actualizarMapaConVoluntarios() {
      // Crea el mapa
      const mapOptions = {
        center: { lat: this.lat, lng: this.lon },
        zoom: 15
      };
      const map = new google.maps.Map(this.$refs.map, mapOptions);

      // Agrega el marcador de la emergencia seleccionada
      if (this.selectedEmergencia) {
        const emergencia = this.emergencias.find(e => e.id === this.selectedEmergencia);
        if (emergencia) {
          const markerEmergencia = new google.maps.Marker({
            position: { lat: this.lat, lng: this.lon },
            map: map,
            title: `Emergencia: ${emergencia.nombre}`
          });
        }
      }

      // Agrega marcadores para la ubicación de los voluntarios
      this.voluntarios.forEach(voluntario => {
        const markerVoluntario = new google.maps.Marker({
          position: { lat: voluntario.latitud, lng: voluntario.longitud },
          map: map,
          title: `Voluntario: ${voluntario.nombre}`
        });
      });
    },
    initMap() {
      // ... (Código del mapa similar al ejemplo anterior)
    }
  }
};
</script>

<style>
.container {
  margin-top: -100px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-size: cover;
  background-position: center;
}

.title {
  font-size: 2em;
  margin-bottom: 20px;
  color: #fff;
  /* Color del texto */
}

.label {
  font-size: 20px;
  margin-bottom: 10px;
  color: black;
  /* Color del texto */
}

.select,
.button {
  padding: 10px;
  margin-bottom: 20px;
}

.map {
  height: 450px;
  width: 600px;
  border: 2px solid #fff;
  /* Color del borde del mapa */
  border-radius: 8px;
}</style>
