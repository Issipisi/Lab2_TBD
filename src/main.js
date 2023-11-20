import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'


import CrearTarea from './views/IngresoTarea.vue' // Importa el componente para editar tareas
import EditarTarea from './views/VerEditarTarea.vue' // Importa el componente para editar tareas
import login from './views/login.vue'
import register from './views/register.vue';
import EmergenciasColumn from './views/EmergenciasColumn.vue';
import TareasColumn from './views/TareasColumn.vue';
import VoluntariosColumn from './views/VoluntariosColumn.vue';
import CrearEmergencia from "@/views/CrearEmergencia.vue";


const routes = [
    {
        path: '/',
        redirect: '/register'
    },
    {
        path: '/register',
        component: register
    },
    {
        path: '/login',
        component: login
    },
    {
        path: '/crearTarea',
        component: CrearTarea,
    },
    {
        path: '/actualizar-tarea/:id',
        component: EditarTarea,
    },
    {
        path: '/emergencias',
        name: 'EmergenciasColumn',
        component: EmergenciasColumn
    },
    {
        path: '/emergencias/:emergenciaId',
        name: 'TareasColumn',
        component: TareasColumn
    },
    {
        path: '/tareas/:tareaId',
        name: 'VoluntariosColumn',
        component: VoluntariosColumn
    },
    {
        path: '/crear-emergencia',
        component: CrearEmergencia,
    },


]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

createApp(App)
    .use(router) 
    .mount('#app')
