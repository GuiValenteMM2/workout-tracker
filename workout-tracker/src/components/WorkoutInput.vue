<script setup>
  import { reactive } from 'vue';
  defineEmits(['add-workout']);
  
  const workout = reactive({
    name: "",
    sets: "",
    reps: "",
    weight: "",
  });
</script>

<template>
  <div class="flex gap-3 m-4 flex-wrap p-2 items-center">
    <button class="border-solid border-2 border-black p-2 rounded-lg mt-6
     bg-red-700 text-lg text-black"
     @click="$emit('add-workout')">Treino Do Dia</button>
     <div>
       <p>Nome:</p>
       <input type="text" v-model="workout.name" class="w-200 h-12 rounded-md ">
     </div>
     <div>
       <p>Séries:</p>
       <input type="number" v-model="workout.sets" class="w-200 h-12 rounded-md">
     </div>
    <div>
      <p>Repetições:</p>
      <input type="number" v-model="workout.reps" class="w-200 h-12 rounded-md">
    </div>
    <div>
      <p>Peso:</p>
      <input type="number" v-model="workout.weight" class="w-200 h-12 rounded-md">
    </div>
  </div>
</template>

