export interface Seller {
    id?: number;
    username: string;
    password: string;
    email: string;
    individual_name?: string;
    company_name?: string;
    postal_address?: string;
    gstin?: string;
    bank_detail?: string;
}