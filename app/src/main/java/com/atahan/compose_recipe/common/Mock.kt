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
        Meal(
            "Campfire stew",
            "Remove the rind and fat from the gammon, then soak in a pan of water in the fridge overnight – this will remove some of the salt.Heat the oil in a large flameproof casserole or ovenproof pan over a medium-high heat and cook the onion, carrots and celery for 10 mins, stirring regularly until the veg starts to soften. Stir in the peppers, garlic, tomato purée, paprika and chilli powder. Cook for another 2 mins, then add the tomatoes and stir. Swill out the tomato cans with a little water and pour this into the casserole. Season well and stir in the Worcestershire sauce, 1 tbsp sugar and the bay leaves.Heat the oven to 170C/150C fan/gas 3. Put the gammon in the casserole, cover and bring to a simmer. Transfer to the oven and cook for 3 hrs until the meat is tender. Carefully lift out the casserole and return to a medium heat on the hob, then add the haricot beans. Simmer for 10 mins until the beans are heated through, then shred the ham using two forks. Serve straightaway. To store, leave to cool completely and chill in an airtight container for up to three days, or freeze for up to two months. Defrost in the fridge overnight before reheating until piping hot.",
            true,
            MealType.MEAT,
            35
        ),
        Meal(
            "Easy chocolate fudge cake",
            "Heat the oven to 180C/160C fan/gas 4. Oil and line the base of two 18cm sandwich tins. Sieve the flour, cocoa powder and bicarbonate of soda into a bowl. Add the caster sugar and mix well.Make a well in the centre and add the golden syrup, eggs, sunflower oil and milk. Beat well with an electric whisk until smooth.Pour the mixture into the two tins and bake for 25-30 mins until risen and firm to the touch. Remove from oven, leave to cool for 10 mins before turning out onto a cooling rack.To make the icing, beat the unsalted butter in a bowl until soft. Gradually sieve and beat in the icing sugar and cocoa powder, then add enough of the milk to make the icing fluffy and spreadable.Sandwich the two cakes together with the butter icing and cover the sides and the top of the cake with more icing.",
            true,
            MealType.DESSERT,
            30
        ),
        Meal(
            "Air fryer roast dinner",
            "Soak the potatoes in water for 30 mins, then drain and rinse. Heat the air fryer for 2 mins. Dry the potatoes thoroughly, then put in a bowl, drizzle over 1 tsp of the oil and season with salt and pepper. Using your hands or a spoon, coat the potatoes in the oil, then put into the air fryer basket, in one layer if possible. Cook for 10 mins at 190C.Meanwhile, coat the chicken in another 1 tsp oil and season with salt and freshly ground black pepper. Once the potatoes have been in for 10 mins, move them to the sides and lay the chicken in the centre of the basket. Cook for 10 mins.Coat the carrots in the remaining oil. After the chicken has cooked for 10 mins, remove it from the basket and add the carrots, mixed in with the potatoes, then move both to the sides and put the chicken back into the centre. Cook for 10-15 mins, still at 190C. At this point, the chicken should be cooked – check by inserting a knife into the thickest part and checking the juices run clear. Alternatively, a meat thermometer should read 70C. If it’s not quite done, cook for a further 5 mins. Remove the chicken and rest it under a piece of tented foil.Put the peas in a small ovenproof dish or mug with 2 tbsp water and cover with foil to prevent any moisture escaping. Put in the air fryer basket where the chicken was and cook for a final 10 mins at 190C. The potatoes should be golden and crisp, the carrots tender and the peas warmed through. Slice the chicken breast and serve with the vegetables and gravy.",
            false,
            MealType.MEAT,
            45
        ),
        Meal(
            "Vegetarian lasagne",
            "To make the tomato sauce, heat the olive oil in a saucepan. Add the onions, garlic and carrot. Cook for 5-7 mins over a medium heat until softened. Turn up the heat a little and stir in the tomato purée. Cook for 1 min, pour in the white wine, then cook for 5 mins until this has reduced by two-thirds. Pour over the chopped tomatoes and add the basil leaves. Bring to the boil then simmer for 20 mins. Leave to cool then whizz in a food processor. Will keep, cooled, in the fridge for up to three days or frozen for three months.To make the white sauce, melt the butter in a saucepan, stir in the plain flour, then cook for 2 mins. Slowly whisk in the milk, then bring to the boil, stirring. Turn down the heat, then cook until the sauce starts to thicken and coats the back of a wooden spoon. Will keep, cooled, in the fridge for up to three days or frozen for three months.Heat the oven to 200C/180C fan/gas 6. Lightly oil two large baking trays and add the peppers and aubergines. Toss with the olive oil, season well, then roast for 25 mins until lightly browned.Reduce the oven to 180C/160C fan/gas 4. Lightly oil a 30 x 20cm ovenproof dish. Arrange a layer of the vegetables on the bottom, then pour over a third of the tomato sauce. Top with a layer of lasagne sheets, then drizzle over a quarter of the white sauce. Repeat until you have three layers of pasta.Spoon the remaining white sauce over the pasta, making sure the whole surface is covered, then scatter over the mozzarella and cherry tomatoes. Bake for 45 mins until bubbling and golden.",
            true,
            MealType.VEGETABLE,
            70
        ),
    )
}

