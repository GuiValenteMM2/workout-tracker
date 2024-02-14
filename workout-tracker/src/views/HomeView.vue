<script setup>
  import WorkoutTab from '../components/WorkoutTab.vue';
  import Workout from '../components/WorkoutInput.vue';
  import { ref } from 'vue';
  import { uid } from 'uid';

  const workoutList = ref([]);

  const addWorkout = (name, date, show) => {
    workoutList.value.push({
      id: uid(),
      name: name,
      date: date,
      show: show,
    })
  }
  
  const deleteWorkout = (idToRemove) => {
    workoutList.value = workoutList.value.filter( workout => workout.id != idToRemove);
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
      @show-exercises="workout.show = !workout.show"
      @delete-workout="deleteWorkout(workout.id)"/>
    </ul>
  </main>
</template>
