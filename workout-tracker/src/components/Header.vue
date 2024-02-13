<script setup>
import { RouterLink } from 'vue-router';

</script>

<template>
  <div class="container bg-red-600 min-w-full"> 
    <div class="text-8xl font-REM flex justify-center bold text-gray-800">Calendário De Treinos</div>
    <nav class="container no-underline p-3 flex gap-4 font-REM text-md justify-center text-gray-800">
      <RouterLink 
       class="focus:border-b-solid active:border-b-white border-transparent border-2 active:font-bold" to="/"
       >Meus Treinos</RouterLink>
      <RouterLink 
      class="focus:border-b-solid active:border-b-white border-transparent border-2 active:font-bold" to="/signup"
      >Cadastre-se</RouterLink>
    </nav>
  </div>
</template>
