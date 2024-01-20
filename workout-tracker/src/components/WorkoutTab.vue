<script setup>
import { reactive, ref } from 'vue';
import Exercises from './ExercisesTab.vue';


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
  
  const addExercise = (name, sets, reps, weight) => {
    exerciseList.value.push({
      name: name,
      sets: sets,
      reps: reps,
      weight: weight,
    })
  };

  const exercise = reactive({
    name: "",
    sets: "",
    reps: "",
    weight: "",
  })

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
            <input type="text" name="Nome" id="exerciseName" v-model="exercise.name">
            <input type="text" name="Séries" id="sets" v-model="exercise.sets">
            <input type="text" name="Repetições" id="reps" v-model="exercise.reps">
            <input type="text" name="Peso" id="weight" v-model="exercise.weight">
            <input type="button" value="Adicionar" id="exerciseBtn" @click="addExercise"
             class="cursor-pointer rounded-md border-b-black border-2 active:bg-gray-300 active:border-b-gray-900">
            <div>
              <table>
                <tr>
                  <th class="p-2">Nome</th>
                  <th class="p-2">Séries</th>
                  <th class="p-2">Repetições</th>
                  <th class="p-2">Peso</th>
                </tr>
                <Exercises v-for="exercise in exerciseList"
                :name="exercise.name"
                :sets="exercise.sets"
                :reps="exercise.reps"
                :weight="exercise.weight"/>
              </table>
          </div>
          </div>
        </div>
    </li>
</template>
