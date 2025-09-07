# TV Series Manager Java Console App

## Project Description

You are tasked with developing a Java console application for a new TV streaming company to manage its list of TV series. The app must allow users to capture, search, update, delete, and view a report of TV series data, all handled in memory using arrays or ArrayLists.

## User Experience Flow

### App Start

Display main menu:
```
LATEST SERIES - 2025

Enter (1) to launch menu or any other key to exit

Please select one of the following menu items:
(1) Capture a new series
(2) Search for a series
(3) Update series age restriction
(4) Delete a series
(5) Print series report - 2025
(6) Exit Application
```

## Functional Requirements

### 1. Capture New Series

Prompt user for:
- SeriesId (String)
- SeriesName (String)
- SeriesAge (String, numeric between 2–18)
- SeriesNumberOfEpisodes (String or int)

Save data to an Array or ArrayList.

Display confirmation message after saving.

#### Age Restriction Validation

Invalid inputs:
- Non-numeric input (e.g., "Ten")
- Numbers outside 2–18

Prompt user to re-enter until valid.

### 2. Search Series

Prompt for SeriesId.

If found: display full details.

If not found: display error message.

### 3. Update Series

Prompt for SeriesId.

Allow updating:
- Series Name
- Age Restriction (2–18)
- Number of Episodes

### 4. Delete Series

Prompt for SeriesId.

Ask for confirmation ("y" to delete).

Display success or error message.

### 5. Print Series Report

List all series from memory in this format:
```
SERIES ID: 101
SERIES NAME: Extreme Sports
SERIES AGE RESTRICTION: 12
NUMBER OF EPISODES: 10
```

### 6. Exit Application

Exit the program.

## Required Classes

### SeriesModel Class

```java
public class SeriesModel {
  public String SeriesId;
  public String SeriesName;
  public String SeriesAge;
  public String SeriesNumberOfEpisodes;
}
```

### Series Class

Handles all logic and methods:
```java
public class Series {
  void CaptureSeries() {...}
  void SearchSeries() {...}
  void UpdateSeries() {...}
  void DeleteSeries() {...}
  void SeriesReport() {...}
  void ExitSeriesApplication() {...}
}
```

Additional helper methods can be added.

## Technologies Used

- Language: Java
- UI: Console-based
- Data Storage: Arrays or ArrayLists

## Notes

- No database or external storage required.
- All data handled in memory during runtime.
- Focus on input validation, clear menu interaction, and structured OOP design.

# Series-app
