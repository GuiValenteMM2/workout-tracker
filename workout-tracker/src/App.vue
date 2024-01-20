<script setup>
import { RouterView } from 'vue-router'
import Header from './components/Header.vue';

</script>

<template>
  <div class="container bg-gray-600 absolute min-h-full min-w-full">
    <Header />
    <RouterView />
  </div>
</template>


