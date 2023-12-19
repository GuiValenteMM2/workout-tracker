<script setup>
import { RouterLink } from 'vue-router';
</script>

<template>
  <div class="container bg-red-600"> 
    <div class="">Workout Tracker</div>
    <nav class="container no-underline">
      <RouterLink class="no-underline" to="/">My Workouts</RouterLink>
      <RouterLink  to="/signup">Sign Up</RouterLink>
    </nav>
  </div>
</template>
