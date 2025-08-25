# 🚚 Shipping Company (Java OOP – Console App)

A **Java console application** that simulates shipping liquid and gas products from **Hamburg Port (Germany)** to major European cities.  
The program computes **volume, weight, best truck combination, and total shipping cost (including return trip)** and is **fully developed using Object-Oriented Programming (OOP) principles**.

---

## 📌 What it does

- Create/select **items** (with density & risk factor)
- Add **orders** (product, gallons, destination city)
- Convert **gallons ↔ m³**, compute **total weight**
- Pick the **best tanker truck combination** automatically (small/medium/large)
- Calculate **final price**: distance-based cost + risk factor + **empty return to Hamburg**
- Print detailed **summaries** for items and orders

---

## 🛢️ Supported Liquids & Risk Factors

- Oxygen (O₂) – **17%**
- Hydrogen (H₂) – **18%**
- Nitrogen (N₂) – **2%**
- Propene – **20%**
- Carbon Dioxide (CO₂) – **10%**
- Methane – **18%**
- Benzene (E95) – **20%**
- Benzene (Super) – **20%**
- Water – **0%**
- Milk – **0%**

> Densities are stored per product and used to compute total weight.

---

## 🚛 Tanker Trucks (cylindrical containers)

- **Small**: Length **300 in**, Radius **24 in**
- **Medium**: Length **380 in**, Radius **40 in**
- **Large**: Length **860 in**, Radius **52 in**

The app computes container **volume = π·r²·h** (inches → gallons) and selects the cheapest valid combination.

---

## 🌍 Cities (from Hamburg)

Berlin · Munich · Leipzig · Dresden · Köln · Rome · Paris · Wien · Madrid

> More cities can be added by extending the distance table.

---

## 📦 Packages & Key Classes

- `calculation/`  
  `Calculation.java` (core logic), `Order.java`, `VolumeConverter.java`, `VolumeConvertible.java`
- `distance/`  
  `Cities.java`, `ShippingCity.java` (names & distances from Hamburg)
- `info/`  
  `Info.java` (author, student id, group, creation date, total lines)
- `liquide/`  
  `Item.java`, `ItemCatalog.java` (name, density, risk, quantityGallon)
- `tanks/`  
  `Truck.java`, `SmallTruck.java`, `MediumTruck.java`, `LargeTruck.java`
- `main/`  
  `ShippingApp.java` (menu flow, input/validation), `Main.java` (entry point)

---

## 🧭 Main Menu & Validation

WELCOME TO THE SHIPPING COMPANY APPLICATION..

## =========== SHIPPING COMPANY MENU ===========
- **1- Show All Items**
- **2- Show All Cities**
- **3- Create New Order**
- **4- Show All Orders**
- **5- Add A New City**
- **6- Show All Trucks**
- **0- Exit**

Your choice:-

**Validation**: non-numeric or out-of-range inputs are rejected with clear messages.

- **Create New Order**: product & city are verified, gallons must be ≥ 0.
- **Best trucks**: chosen by total volume; multiple trucks can be combined.
- **Cost**: base €/km/gal **+ risk%**; **empty return** to Hamburg costs **€0.6/km** and is included.

---

## 📜 License

This project is licensed under the **MIT License**.  
See the [LICENSE](./LICENSE) file for details.

