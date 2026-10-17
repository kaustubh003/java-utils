# utils

A tiny Java utility library.

Java version: 21

## Features

- Safe string trimming
- Default handling for blank strings
- Join collections into a delimited string
- Format Java `Duration` values into a readable string

## Getting started

### Prerequisites

- Java 21+
- Maven 3.9+

### Build

```bash
mvn -B test
```

How it works
------------

*   trimToEmpty(String) — returns "" for null, or the trimmed string for non-null input.

*   defaultIfBlank(String, defaultValue) — returns defaultValue when the input is null or blank (after trimming).

*   join(Collection, delimiter) — joins non-null elements, skipping nulls; returns "" for null/empty collection.

*   join(CharSequence\[\], delimiter, skipNulls) — array overload; set skipNulls to true to skip nulls, or false to include the literal "null" for null elements.

*   sanitizeList(Collection, removeBlank) — trims each element, converts nulls to empty string, and optionally removes blank entries if removeBlank is true.

*   formatDuration(Duration) — formats durations as Xd Yh Zm Ss (days included).