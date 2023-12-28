<script setup>
  import Workout from '../components/WorkoutInput.vue';
  import { ref } from 'vue';

  const workoutList = ref([]);

  const addWorkout = (workout) => {
    workoutList.value.push({
      name: workout,
      date: date,
    })
  }
  
</script>

<template>
  <main>
    <Workout />
  </main>
</template>
