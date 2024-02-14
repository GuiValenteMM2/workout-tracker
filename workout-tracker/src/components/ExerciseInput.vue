<script setup>
    import { reactive } from 'vue';
    
    const emit = defineEmits(['add-exercise']);

    const exercise = reactive({
    name: "",
    sets: "",
    reps: "",
    weight: "",
    invalid: null,
    invalidMsg: "",
  });

  const addExercise = () => {
    exercise.invalid = false;
    for (let key in exercise) {
        if (exercise[key] != "") {
            emit('add-exercise', exercise.name, exercise.sets, exercise.reps, exercise.weight);
            exercise.name = "";
            exercise.sets = "";
            exercise.reps = "";
            exercise.weight = "";
            return;
        };
    };
    exercise.invalid = true;
    exercise.invalidMsg = "Por favor preencha os campos";
  };
</script>

<template>
    <input type="text" name="Nome" id="exerciseName" v-model="exercise.name">
    <input type="text" name="Séries" id="sets" v-model="exercise.sets">
    <input type="text" name="Repetições" id="reps" v-model="exercise.reps">
    <input type="text" name="Peso" id="weight" v-model="exercise.weight">
    <input type="button" value="Adicionar" id="exerciseBtn" @click="addExercise()"
        class="cursor-pointer rounded-md border-b-black border-2 active:bg-gray-300 active:border-b-gray-900">
</template>