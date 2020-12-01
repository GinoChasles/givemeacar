import React, { useState } from "react";

export default function ClientCard(client) {
  const { lastName, firstName, mail, phone, adresse, agency } = client;
  const { name } = agency;
  const { number, suffix, street, city } = adresse;
  return <div></div>;
}
