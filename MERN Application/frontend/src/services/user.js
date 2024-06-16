import axios from "axios";
import { createUrl, createErrorResult } from "./utils";

export async function register(name, email, address) {
  try {
    const url = createUrl("register");
    const body = { name, email, address };
    const response = await axios.post(url, body);
    return response.data;
  } catch (ex) {
    return createErrorResult(ex);
  }
}

export const search = async (email) => {
  try {
    const url = createUrl("search");
    const body = { email };
    const response = await axios.post(url, body);
    return response.data;
  } catch (ex) {
    return createErrorResult(ex);
  }
};
