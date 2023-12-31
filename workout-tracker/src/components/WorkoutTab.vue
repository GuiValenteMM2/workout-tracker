<script setup>

  defineEmits(['show-exercises']);

  const prop = defineProps({
    name: {
      type: String,
      required: true,
    },
    date: {
      type: String,
      required: true,
    },
  });

</script>

<template>
    <li class="flex flex-wrap gap-5">
      <div class="border-white border-2 bg-gray-400 w-400 p-4 rounded-md m-2 flex flex-wrap gap-2 justify-center">
        <p>{{ name }}</p>
        <span>{{ date }}</span>
        <button class="border-b-black border-2 rounded-md p-1" @click="$emit('show-exercises')">Exercícios</button>
      </div>
    </li>
</template>
