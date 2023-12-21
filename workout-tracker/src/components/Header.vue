<script setup>
import { RouterLink } from 'vue-router';
</script>

<template>
  <div class="container bg-red-600"> 
    <div class="text-8xl font-REM flex justify-center bold">Workout Tracker</div>
    <nav class="container no-underline p-3 flex gap-4 font-REM text-md justify-center">
      <RouterLink class="hover:border-b-solid  hover:border-b-white border-transparent border-2" to="/">My Workouts</RouterLink>
      <RouterLink class="hover:border-b-solid  hover:border-b-white border-transparent border-2" to="/signup">Sign Up</RouterLink>
    </nav>
  </div>
</template>
