<script setup>
  import WorkoutTab from '@/components/WorkoutTab.vue';
  import Workout from '../components/WorkoutInput.vue';
  import { ref } from 'vue';

  const workoutList = ref([]);

  const addWorkout = (name, date, show) => {
    workoutList.value.push({
      name: name,
      date: date,
      show: show,
    })
  }
  

</script>

<template>
  <main>
    <Workout @add-workout="addWorkout"/>
    <ul>
      <WorkoutTab v-for="workout in workoutList"
      :name="workout.name" 
      :date="workout.date"
      :show="workout.show"
      @show-exercises="workout.show = !workout.show"/>
    </ul>
  </main>
</template>
