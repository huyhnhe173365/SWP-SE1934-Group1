import Head from 'next/head';
import React from 'react';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Toaster } from '@/components/components/ui/sonner';
import Header from '@/components/Header';
import Footer from '@/components/Footer';

const MainLayout = ({ children }) => {
	return (
		<div>
			<Head>
				<title>Delivery </title>
				<meta
					name='description'
					content='Find holiday rentals, cabins, beach houses, unique homes and experiences around the world – all made possible by Hosts on Airbnb.'
				/>
				<link rel='icon' href='images/logo.svg' />
			</Head>
			<main className='w-full relative'>
				<div>
					<Header />
					{children}
					<Footer />
				</div>
				<Toaster position='top-right' richColors />
				<ToastContainer />
			</main>
		</div>
	);
};

export default MainLayout;
