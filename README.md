# Aero-Formula
Solve aerospace/aeronautical formulas, mainly intended for Kerbal Space Program and an edX course.

### List of classes in chronological order of creation:

isa: Calculations for the international standard atmosphere.
converter: unit conversions


### Planned formulas
Lift/drag
Longitudinal Static Stability
Thrust

### Eventual Goals
1. Port to android app

### Existing Issues

1. Accuracy depends on how many digits the gravity constant is rounded to. -9.8 is used for simplicity, which may lead to slight inaccuracy. Other values tried: -9.81, -9.80665

### Bugs

1. Findpressure only work for troposphere, need to use recursion for base values of other layers?
