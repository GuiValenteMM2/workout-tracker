<script setup>
  import WorkoutTab from '@/components/WorkoutTab.vue';
  import Workout from '../components/WorkoutInput.vue';
  import { ref } from 'vue';

  const workoutList = ref([]);

  const addWorkout = (name, date) => {
    workoutList.value.push({
      name: name,
      date: date,
    })
  }
  
  const showBool = ref(false);


</script>

<template>
  <main>
    <Workout @add-workout="addWorkout"/>
    <ul>
      <WorkoutTab v-for="workout in workoutList"
      :name="workout.name" 
      :date="workout.date"
      :show="showBool"
      @show-exercises="showBool = !showBool"/>
    </ul>
  </main>
</template>
