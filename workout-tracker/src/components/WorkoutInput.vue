<script setup>
  import { reactive } from 'vue';

  const emit = defineEmits(['add-workout']);
  
  const workout = reactive({
    name: "",
    date: "",
    invalid: null,
    errMsg: "",
    show: false,
  });

  const addWorkout = () => {
    workout.invalid = false;
    if (workout.name !== "" || workout.date !== "") {
      emit('add-workout', workout.name, workout.date);
      workout.name = "";
      workout.date = "";
      return;
    };
    workout.invalid = true;
    workout.errMsg = "* Por favor preencha os campos!";
  };
</script>

<template>
  <div class="flex gap-3 m-2 flex-wrap p-2 items-center border-b-2 border-double border-black">
    <button class="border-solid border-2 border-black p-2 rounded-lg mt-6
     bg-red-700 text-lg text-black
     active:bg-red-950 active:border-gray-500 focus:bg-red-800"
     @click="addWorkout()">Treino Do Dia</button>
     <div>
       <p>Nome:</p>
       <input type="text" v-model="workout.name" class="w-200 h-12 rounded-md ">
     </div>
     <div>
      <p>Data:</p>
      <input type="date" v-model="workout.date" class="w-200 h-12 rounded-md">
     </div>
     <p class="text-white text-lg border-b-2 border-white" v-show="workout.invalid">{{ workout.errMsg }}</p>
  </div>
</template>

