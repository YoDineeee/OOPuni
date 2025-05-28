package Laboo0

// Class to classify the creatures
class UniverseClassifier {
    // Create a Mutable List of universes
    val universes = listOf(
        Universe("starWars"),
        Universe("marvel"),
        Universe("hitchHiker"),
        Universe("rings"),
        Universe("unidentified")
    )

    // Method to check if the traits are right
    private fun requiredTraits(creatureTraits: List<Traits>?, trait1: Traits, trait2: Traits): Boolean {
        if (creatureTraits.isNullOrEmpty()) {
            return true
        } else if (creatureTraits.size > 1) {
            return trait1 in creatureTraits && trait2 in creatureTraits
        } else {
            return trait1 in creatureTraits || trait2 in creatureTraits
        }
    }

    private fun checkRequirements(
        creature: Creature,
        expectedIsHumanoid: Boolean,
        expectedPlanet: Planet,
        expectedAge: Int,
        trait1: Traits,
        trait2: Traits
    ): Boolean {
        return (creature.isHumanoid == expectedIsHumanoid || creature.isHumanoid == null) &&
                (creature.planet == expectedPlanet || creature.planet == null) &&
                (creature.age == null || creature.age <= expectedAge) &&
                (requiredTraits(creature.traits, trait1, trait2))
    }

    // Method to identify a null object
    private fun isAllNull(creature: Creature): Boolean {
        return creature.isHumanoid == null &&
                creature.planet == null &&
                creature.age == null &&
                creature.traits == null
    }

    // Method to classify the creatures
    fun classify(creatures: List<Creature>) {
        for (creature in creatures) {
            when {
                isAllNull(creature) -> universes[4].individuals.add(creature)
                checkRequirements(
                    creature,
                    false,
                    Planet.Kashyyyk,
                    400,
                    Traits.HAIRY,
                    Traits.TALL
                ) || checkRequirements(
                    creature,
                    false,
                    Planet.Endor,
                    60,
                    Traits.SHORT,
                    Traits.HAIRY
                ) -> universes[0].individuals.add(creature)

                checkRequirements(
                    creature,
                    true,
                    Planet.Asgard,
                    5000,
                    Traits.BLONDE,
                    Traits.TALL
                ) -> universes[1].individuals.add(creature)

                checkRequirements(
                    creature,
                    true,
                    Planet.Betelgeuse,
                    100,
                    Traits.EXTRA_ARMS,
                    Traits.EXTRA_HEAD
                ) || checkRequirements(
                    creature,
                    false,
                    Planet.Vogsphere,
                    200,
                    Traits.GREEN,
                    Traits.BULKY
                ) -> universes[2].individuals.add(creature)

                checkRequirements(
                    creature,
                    true,
                    Planet.Earth,
                    Int.MAX_VALUE,
                    Traits.BLONDE,
                    Traits.POINTY_EARS
                ) || checkRequirements(
                    creature,
                    true,
                    Planet.Earth,
                    200,
                    Traits.SHORT,
                    Traits.BULKY
                ) -> universes[3].individuals.add(creature)

                else -> universes[4].individuals.add(creature)
            }
        }
    }
}