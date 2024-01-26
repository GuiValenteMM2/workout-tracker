<script setup>
import { ref } from 'vue';
import Exercises from './ExercisesTab.vue';
import ExerciseInput from './ExerciseInput.vue';


  defineEmits(['show-exercises']);

  defineProps({
    name: {
      type: String,
      required: true,
    },
    date: {
      type: String,
      required: true,
    },
    show: {
      type: Boolean,
    },
  });

  const exerciseList = ref([]);
  
  const addExercise = (exName, sets, reps, weight) => {
    exerciseList.value.push({
      exName: exName,
      sets: sets,
      reps: reps,
      weight: weight,
    });
  };

</script>

<template>
    <li class="flex flex-wrap gap-5">
        <div class="border-white border-2 bg-gray-400 w-400 p-4 rounded-md m-2 flex flex-wrap gap-2 flex-col  items-center max-w-400">
          <div class="flex gap-2 items-center m-2">
            <p>{{ name }}</p>
            <span>{{ date }}</span>
            <button class="border-b-black border-2 rounded-md p-1" @click="$emit('show-exercises')">Exercícios</button>
          </div>
          <div v-show="show == true" class="exerciseTab flex gap-2 flex-col w-200">
            <ExerciseInput @add-exercise="addExercise"/>
            <div>
              <table>
                <tr>
                  <th class="p-2">Nome</th>
                  <th class="p-2">Séries</th>
                  <th class="p-2">Repetições</th>
                  <th class="p-2">Peso</th>
                </tr>
                <Exercises v-for="exercise in exerciseList"
                :name="exercise.exName"
                :sets="exercise.sets"
                :reps="exercise.reps"
                :weight="exercise.weight"/>
              </table>
          </div>
          </div>
        </div>
    </li>
</template>
