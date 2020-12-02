import React, { useState } from "react";

export default function UserCard({ user }) {
  const { lastName, firstName, mail, phone } = user;
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "row",
        gap: "1rem",
      }}
    >
      <div>
        <div>lastName</div>
        <div>firstName</div>
        <div>mail</div>
        <div>phoneNumber</div>
      </div>
      <div>
        <div>
          <input type="checkbox" id="" name="check" />
          <label for="check"></label>
        </div>
        <div>{lastName}</div>
        <div>{firstName}</div>
        <div>{mail}</div>
        <div>{phone}</div>
      </div>
    </div>
  );
}
