<script setup>
import { reactive } from 'vue';


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
  });

  const exercise = reactive({
    name: "",
    sets: "",
    reps: "",
    weight: "",
  })

</script>

<template>
    <li class="flex flex-wrap gap-5">
        <div class="border-white border-2 bg-gray-400 w-400 p-4 rounded-md m-2 flex flex-wrap gap-2 flex-col  items-center max-w-screen-md">
          <div class="flex gap-2 items-center m-2">
            <p>{{ name }}</p>
            <span>{{ date }}</span>
            <button class="border-b-black border-2 rounded-md p-1" @click="$emit('show-exercises')">Exercícios</button>
          </div>
          <div class="exerciseTab flex gap-2 flex-col">
            <input type="text" name="Nome" id="exerciseName">
            <input type="text" name="Séries" id="sets">
            <input type="text" name="Repetições" id="reps">
            <input type="text" name="Peso" id="weight">
            <input type="button" value="Adicionar" id="exerciseBtn">
          </div>
        </div>
    </li>
</template>
