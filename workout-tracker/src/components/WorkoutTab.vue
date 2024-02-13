<script setup>
import { ref } from 'vue';
import Exercises from './ExercisesTab.vue';
import ExerciseInput from './ExerciseInput.vue';
import { uid } from 'uid';

  defineEmits(['show-exercises', 'delete-workout']);

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
      id: uid(),
    });
  };

const removeExercise = (exerciseId) => {
  exerciseList.value = exerciseList.value.filter(exercise => exercise.id != exerciseId);
};

</script>

<template>
    <li class="flex flex-wrap gap-5">
        <div class="border-white border-2 bg-gray-400 w-400 p-4 rounded-md m-2 flex flex-wrap gap-2 flex-col  items-center max-w-400">
          <div class="flex gap-2 items-center m-2">
            <p>{{ name }}</p>
            <span>{{ date }}</span>
            <button class="border-b-black border-2 rounded-md p-1" @click="$emit('show-exercises')">Exercícios</button>
            <button @click="$emit('delete-workout')">
              <svg xmlns="http://www.w3.org/2000/svg" width="2em" height="2em" viewBox="0 0 24 24" class="active:text-white">
		          <path fill="currentColor" d="M9 3v1H4v2h1v13a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V6h1V4h-5V3zM7 6h10v13H7zm2 2v9h2V8zm4 0v9h2V8z" />
	            </svg>
            </button>
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
                :weight="exercise.weight"
                :isEditing="editing"
                @delete-exercise="removeExercise(exercise.id)"
                @edit-exercise="editExercise(exercise.id)" />
              </table>
          </div>
          </div>
        </div>
    </li>
</template>
