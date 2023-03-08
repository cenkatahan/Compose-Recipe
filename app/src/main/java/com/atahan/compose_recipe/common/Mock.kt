package com.atahan.compose_recipe.common

import com.atahan.compose_recipe.model.Meal
import com.atahan.compose_recipe.model.MealType

object Mock {
    fun fetchMockMeals() = arrayListOf(
        Meal("Apple", "A Fruit", false, MealType.FRUIT, 1),
        Meal("Hamburger", "Cook meat and patty. Put ingredients.", false, MealType.FAST_FOOD, 12),
        Meal("Pizza", "Put ingredients on dough. Cook in the oven", false, MealType.FAST_FOOD, 25),
        Meal(
            "Healthy lasagne",
            "Heat the oven to 180C/160C fan/gas 4. Heat the oil in a large frying pan over a medium heat and fry the onion, carrots, celery and one of the bay leaves for 8-10 mins until the veg softens and is starting to turn golden. Add the mince and garlic, and stir-fry until the beef browns, about 5 mins. Tip in the tomatoes and a canful of water, the tomato purée and bouillon, bring to the boil, then cover and simmer for 20 mins, removing the lid after 10 mins to reduce the mixture slightly.Meanwhile, pour the milk into a medium pan with the flour and whisk over a low heat until the mixture is lump-free. Add the second bay leaf and a good pinch of nutmeg, and continue to cook, whisking, for 8-10 mins until thick.Remove the bay from the mince and white sauce, and discard. Spoon a third of the mince into the base of a 19 x 24cm baking dish and top with two lasagne sheets. Spoon over half of the remaining mince, then top with two more lasagne sheets, the rest of the mince and the remaining lasagne sheets. Spoon over the white sauce and sprinkle with the cheese. Bake for 40 mins until bubbling and golden.",
            false,
            MealType.FRUIT,
            15
        ),
        Meal(
            "Fish tacos",
            "Combine the cumin, coriander, paprika and a generous pinch of salt in a large bowl, add the juice from 1 lime and mix well. Toss the fish fillets in the spiced lime paste and set aside while you prepare the salad.Finely slice the cabbage – you can do this by hand or in a food processor if you want it really fine – squeeze over the juice from half a lime and season with a little salt, scrunch the salt and lime into the cabbage and set aside. Chop the tomatoes into small pieces. Stone the avocado, scoop out the soft inside and slice, or if it’s a very ripe avocado you may want to mash it in a bowl with a little lime and salt. Keep all the salad ingredients separate on a board.Heat the grill to high. Line a baking tray with foil and brush with a little oil, place the fish fillets on the tray, pour over any paste from the bowl and brush with a little more oil. Cook the fish close to the grill for 8-10 mins until the fish is cooked and starting to scorch in places, to check its cooked, gently push one of the fillets, it should easily flake when cooked.If you have a gas hob, warm the tortillas directly over the flames with a pair of tongs for a charred finish. Alternatively, wrap in foil and warm in the oven on the shelf beneath the fish.To serve, spread a little soured cream over each warm tortilla, top with a handful of cabbage, some tomatoes and a few slices of avocado. Flake the fish and add a few big chunks to each tortilla then top with coriander, chilli and chilli sauce.",
            false,
            MealType.FRUIT,
            1
        ),
    )
}