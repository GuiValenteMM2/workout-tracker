<script setup>
  import { reactive } from 'vue';

  defineEmits(['add-workout']);

  defineProps({
    name: {
      type: Object,
      required: true,
    },
    date: {
      type: Number,
      required: true,
    }
  })
  
  const workout = reactive({
    name: "",
    date: "",
  });
</script>

<template>
  <div class="flex gap-3 m-4 flex-wrap p-2 items-center border-b-2 border-double border-black">
    <button class="border-solid border-2 border-black p-2 rounded-lg mt-6
     bg-red-700 text-lg text-black"
     @click="$emit('add-workout')">Treino Do Dia</button>
     <div>
       <p>Nome:</p>
       <input type="text" v-model="workout.name" class="w-200 h-12 rounded-md ">
     </div>
     <div>
      <p>Data:</p>
      <input type="date" v-model="workout.date" class="w-200 h-12 rounded-md">
     </div>
  </div>
</template>

