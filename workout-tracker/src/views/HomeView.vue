<script setup>
  import Workout from '../components/WorkoutInput.vue';
  import { ref } from 'vue';

  const workoutList = ref([]);
  
</script>

<template>
  <main>
    <Workout />
  </main>
</template>
