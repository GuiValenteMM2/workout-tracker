<script setup>

defineEmits(['add-exercise', 'delete-exercise', 'edit-exercise']);

defineProps({
    name: {
        type: String,
        required: true,
    },
    sets: {
        type: String,
        required: true,
    },
    reps: {
        type: String,
        required: true,
    },
    weight: {
        type: String,
        required: true,
    }
});

</script>

<template>
    <tr class="">
        <td v-if="isEditing"><input type="text" name="name" :value="name"></td>
        <td class="p-2">{{ name }}</td>
        <td v-if="isEditing"><input type="text" name="sets" :value="sets"></td>
        <td class="p-2">{{ sets }}</td>
        <td v-if="isEditing"><input type="text" name="reps" :value="reps"></td>
        <td class="p-2">{{ reps }}</td>
        <td v-if="isEditing"><input type="text" name="weight" :value="weight"></td>
        <td class="p-2">{{ weight }}</td>
        <td><button @click="$emit('edit-exercise')">
            <svg xmlns="http://www.w3.org/2000/svg" width="1.5em" height="1.5em" viewBox="0 0 24 24" class="active:text-white">
		<path fill="currentColor" d="M20.71 7.04c.39-.39.39-1.04 0-1.41l-2.34-2.34c-.37-.39-1.02-.39-1.41 0l-1.84 1.83l3.75 3.75M3 17.25V21h3.75L17.81 9.93l-3.75-3.75z" />
	</svg>
        </button></td>
        <td><button @click="$emit('delete-exercise')">
                <svg xmlns="http://www.w3.org/2000/svg" width="1.5em" height="1.5em" viewBox="0 0 24 24" class="active:text-white">
		          <path fill="currentColor" d="M9 3v1H4v2h1v13a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V6h1V4h-5V3zM7 6h10v13H7zm2 2v9h2V8zm4 0v9h2V8z" />
	            </svg>
            </button></td>
    </tr>
</template>