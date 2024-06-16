import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { register } from "../services/user";
import { toast } from "react-toastify";

function RegisterUser() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");

  const navigate = useNavigate();

  const onRegister = async () => {
    if (name.length === 0) {
      toast.warning("enter name");
    } else if (email.length === 0) {
      toast.warning("enter email");
    } else if (address.length === 0) {
      toast.warning("enter address");
    } else {
      const result = await register(name, email, address);
      if (result["status"] === "success") {
        toast.success("Registered in successfully");
        //navigate to main
        navigate("/home");
      } else {
        toast.error(result["error"]);
      }
    }
  };

  return (
    <div className="register">
      <h1>Register</h1>
      <div>
        <label htmlFor="Name">Name :</label>
        <input onChange={(e) => setName(e.target.value)} type="text" placeholder="enter your name" id="Name" />
      </div>
      <div>
        <label htmlFor="Email">Email :</label>
        <input onChange={(e) => setEmail(e.target.value)} type="email" placeholder="abc@gmail.com" id="Email" />
      </div>
      <div>
        <label htmlFor="Address">Address :</label>
        <input onChange={(e) => setAddress(e.target.value)} type="text" placeholder="Address here" id="Address" />
      </div>
      <button className="btn btn-success" onClick={onRegister} style={{ marginInline: "5%" }}>
        Register
      </button>
    </div>
  );
}

export default RegisterUser;
