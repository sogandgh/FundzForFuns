# Fundz for Funz 🧁

*Making budgeting fun for college students.*

An Android app that turns your discretionary "fun money" into a cupcake — set your income and
expenses, and the cupcake shrinks as you spend, warning you before you're out of funds.

🏆 **Best Financial Hack** (Capital One) and **Best AWS Hack** (AWS) — [Technica](https://gotechnica.org/) 2018
📄 [Devpost submission](https://devpost.com/software/fundzforfunz)

> Built in 2018 at Technica; this repo was split out from the original shared team project and
> published here in 2026. Code and history are otherwise untouched from the hackathon.

<p align="center">
  <img src="docs/cupcake-depletion.png" width="700" alt="Cupcake depleting from full to empty as budget is spent">
</p>

*Same cupcake, spent down: full fun budget on the left, nothing left on the right.*

---

## Why

College students spend disproportionately on dining and going out relative to their income, encouraged by "food porn" social media culture. Most budgeting apps respond with spreadsheets and category breakdowns, which is exactly the kind of chore nobody
actually keeps up with. Fundz for Funz tries a different angle: one visual, one number, no
spreadsheet. You know your budget's status at a glance because the cupcake tells you.

## What it does

1. **Register / log in.**
2. **Set a budget** — income, fixed expenses, and how much is left over to spend on "fun":
   clothes, eating out, events, movies, subscriptions, and other.
3. **Log spending** against those categories as it happens.
4. **Watch the cupcake.** It's rendered at one of ten states depending on how much of the fun
   budget remains, from a fully frosted cupcake down to Bob, sad, and empty. Once the budget's
   gone, the app flags it so you know to hold off.

## How it's built

| Layer | Stack |
|---|---|
| Client | Android (Java), min SDK 19 / target SDK 28, Volley + Unirest for HTTP |
| Backend | Python + Flask, hosted on Amazon EC2 |
| Data | DynamoDB, accessed through a Python ORM |
| Design assets | Vectr, Canva |

The backend is a separate Flask/DynamoDB service — this repo is the Android client. It talks to
five REST routes:

| Method | Route | Purpose |
|---|---|---|
| `POST` | `/register` | create an account |
| `POST` | `/login` | authenticate |
| `POST` | `/expenses` | create a budget profile (income / expense / saving) |
| `PUT`  | `/expense` | add a spend to a category |
| `GET`  | `/expense/{username}` | fetch a user's current profile |

All of it goes through [`API.java`](app/src/main/java/com/sdproject/sogand/hackathon/API.java),
which points at `Config.BASE_URL` — see [Running it](#running-it) below.

## Running it

The original hackathon backend (an EC2 box) no longer exists, and its address has been scrubbed
from this repo along with the credentials that were checked in alongside it back in 2018 — don't
reuse either. To run the app against your own backend:

1. Stand up a server implementing the routes above.
2. Set `BASE_URL` in
   [`Config.java`](app/src/main/java/com/sdproject/sogand/hackathon/Config.java) to your server's
   address (e.g. `http://10.0.2.2:5050` to reach `localhost` from the Android emulator).
3. Open the project in Android Studio and run it on an emulator or device (min SDK 19).

## Known limitations

This shipped as a 24-hour hackathon prototype, not a production app, and it shows:

- Passwords are sent as **plain integers over unencrypted HTTP** — fine for a demo network, not
  for anything real.
- No offline mode, input validation is minimal, and the UI layer is tightly coupled to the network
  calls (see `MainActivity`, `Register`, `home`, `profile`, `fun`).

## What's next (from the original pitch)

- Home-screen widget showing live budget status
- Monday reminders for unused fun budget
- Financial tips
- Long-term savings goal tracking

## License

No license has been chosen yet — all rights reserved by default until one is added.
